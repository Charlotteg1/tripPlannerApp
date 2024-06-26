import { useState } from "react";
import { TextInput, SafeAreaView, Text, StyleSheet, View, Pressable } from "react-native";

const Login = ({navigation}) => {
    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');
    const [error,setError] = useState();
    const [currentUser, setCurrentUser] = useState();

    const checkLogin = async () => {
        if(!password || !email){
            setError("please enter all fields")
            setEmail()
            setPassword();
            return;
        }
        if(email.includes('@')){
            if(password && password.length > 7){
                const loginDetails = {
                    "email" : email.toLowerCase(),
                    "password" : password
                }
                const authorised = await authenticateUser(loginDetails) 
                if(authorised){
                    setError()
                    setEmail()
                    setPassword()
                    navigation.navigate('trips', {currentUser: currentUser});
                }else{
                    setError("email or password does not match")
                    setEmail()
                    setPassword();
                }
            }else{
                setError("Password should be at least 8 characters long")
                setEmail()
                setPassword()
            }
        }else{
            setError("Please submit a valid email format")
            setEmail()
            setPassword();
        }
    }

    const authenticateUser = async (loginDetails) => {
        const url = `http://localhost:8080/user/authenticate`;
        const response = await fetch(url, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(loginDetails)
        });
        if (response.status === 200) {
            const user = await response.json();
            console.log(user)
            setCurrentUser(user)
            return true;
        } else {
            return false;
        }
      };


    const handleCreateAccountRequest = () =>{
        setEmail()
        setPassword()
        navigation.navigate("createAccount");
    }

    
    return(
    <SafeAreaView style={styles.loginPage}>
    <Text style={styles.title}>Travel Planner</Text>
    <Text style={styles.login}> Login</Text>
    <View style={styles.entryBox} >
        <Text style={styles.text}> Email:</Text>
        <TextInput style={styles.textInput} onChangeText={(text) => { setEmail(text) }} value={email}/>
        <Text style={styles.text}> Password:</Text>
        <TextInput style={styles.textInput} onChangeText={(text) => { setPassword(text) }} value={password}/>
        <Pressable style={styles.submit} onPress={checkLogin}>
            <Text style={[styles.text, { textAlign: 'center' }]}>Login</Text>
        </Pressable>
    </View>
    {error && (!email || email.length === 0) && (!password || password.length === 0) && 
    <View style={styles.errorBox}>
     <Text style={styles.error}>Error : {error}</Text>
    </View>}
    <Pressable style={styles.newAccountButton} onPress={()=> handleCreateAccountRequest()} >
        <Text style={styles.newAccountText}>Create New account</Text>
    </Pressable>
    
    </SafeAreaView>)
}

const styles = StyleSheet.create({
    loginPage:{
        flex: 1,
        backgroundColor: '#E8EBEE',
        alignItems: 'center',
    },
    title:{
        fontFamily: 'Courier New',
        color: '#45555E',
        fontWeight: 'bold',
        marginTop: 105, 
        fontSize: 40,
    },
    login:{
        fontFamily: 'Courier New',
        color: '#1F6F3E',
        marginTop: 105, 
        fontSize: 24,
    },
    entryBox: {
        width: '80%',
        height: '25%',
        marginTop: 5, 
        borderColor:'#45555E',
        borderWidth: 1,
        borderRadius: 15,
        paddingVertical:20,
        paddingHorizontal: 5,
        backgroundColor: '#DCE0E5',
        shadowOpacity: '0.2%',
        shadowColor: '#3D4652',
      },
    text: {
        fontFamily: 'Courier New',
        color: '#124023',
        fontSize: 18,
    },
    textInput: {
        fontFamily: 'Courier New',
        backgroundColor: '#E8EBEE',
        color: '#083436',
        fontWeight: 'bold',
        fontSize: 18,
        padding: 8,
        marginTop: 3, 
        marginBottom: 10,
        borderColor:'#45555E',
        borderWidth: 1,
        borderRadius: 5,
        marginHorizontal: 5,
    },
    submit: {
        alignSelf: 'center',
        marginTop: 2,
        backgroundColor: '#FDEBC3',
        padding: 8,
        borderRadius:10,
        width: 100,
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
    },
    // add animation later to alert user to error
    errorBox:{
        width: '80%',
        borderColor:'#FF3347',
        backgroundColor: '#FFEBED',
        borderWidth: 1,
        borderRadius: 15,
        marginTop: 12,
        padding: 10,
    },
    error:{
        textAlign: 'center',
        fontFamily: 'Courier New',
        color: '#3D4652',
        fontWeight: 'bold',
    },
    newAccountButton: {
        alignSelf: 'center',
        backgroundColor: '#E3C16F',
        padding: 8,
        borderRadius:10,
        width: '60%',
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
        position: 'absolute',
        bottom: '20%',

    },
    newAccountText: {
        fontFamily: 'Courier New',
        color: '#124023',
        fontSize: 20,
        textAlign:'center'
    },

  });
export default Login;