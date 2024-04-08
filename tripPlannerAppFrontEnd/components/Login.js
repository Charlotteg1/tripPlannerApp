import { useState } from "react";
import { Button,TextInput, SafeAreaView, Text } from "react-native";

const Login = ({navigation}) => {


    const [email,setEmail] = useState();
    const [password,setPassword] = useState();
    const [error,setError] = useState();
    // first check password is of correct length and email include  a @ etc
    // send to check password and email
    // display error if incorrect/user not found
    // if correct send/view to page
    const checkLogin = () => {
        if(!password && !email){
            setError("please enter all fields")
            return;
        }
        // check email includes @
        if(email.includes('@')){
            if(password && password.length > 7){
                navigation.navigate('trips');
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
    return(
    <SafeAreaView>
    <Text style={{ fontSize: 34 }}>Welcome</Text>
    {/* set up login box */}
    <Text style={{ fontSize: 24 }}> Please Login:</Text>
    <Text style={{ fontSize: 34 }}> Email:</Text>
    <TextInput onChangeText={(text) => setEmail(text)} value={email}/>
    <Text style={{ fontSize: 34 }}> Password:</Text>
    <TextInput onChangeText={(text) => setPassword(text)} value={password}/>
    <Button onPress={checkLogin} title="Login"/>
    {error && <Text>Error : {error}</Text>}
    </SafeAreaView>)
}
export default Login;