import { useState } from "react";
import { TextInput, SafeAreaView, Text, StyleSheet, View, Pressable } from "react-native";


// for when a user needs to create a new account, will navigate to addTrip page after registartion.
const Signup = ({navigation}) => {

    const [email,setEmail] = useState('');
    const [password,setPassword] = useState('');
    const [error, setError] = useState();

    const handleSignUp = () => {
        return true;
    }

    const handleLoginPageRequest = () => {
        navigation.navigate('login')
        return true;
    }

    return(
        <SafeAreaView style={styles.createAccountPage}>
        <Text style={styles.title}>Travel Planner</Text>
        <Text style={styles.signup}>Sign Up</Text>
        <View style={styles.entryBox} >
            <Text style={styles.text}> Enter Email:</Text>
            <TextInput style={styles.textInput} onChangeText={(text) => { setEmail(text); setError(null); }} value={email}/>
            <Text style={styles.text}> Enter Password:</Text>
            <TextInput style={styles.textInput} onChangeText={(text) => { setPassword(text); setError(null); }} value={password}/>
            <Pressable style={styles.submit} onPress={()=> handleSignUp()}>
                <Text style={[styles.text, { textAlign: 'center' }]}>Sign Up</Text>
            </Pressable>
        </View>
        {error && 
        <View style={styles.errorBox}>
         <Text style={styles.error}>Error : {error}</Text>
        </View>}
        <Pressable style={styles.newAccountButton} onPress={()=> handleLoginPageRequest()} >
            <Text style={styles.newAccountText}>Login</Text>
        </Pressable>
        
        </SafeAreaView>)
    }
    
    const styles = StyleSheet.create({
        createAccountPage:{
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
        signup:{
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

export default Signup;