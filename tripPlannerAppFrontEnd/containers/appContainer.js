import { NavigationContainer } from "@react-navigation/native";
import Login from "../components/Login";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
const Stack = createNativeStackNavigator();


const AppContainer = () => {

    
    return(
        <NavigationContainer>
            <Stack.Navigator>
                    <Stack.Screen name="login" component={Login} options={{
                        headerShown: false
                    }}/>
            </Stack.Navigator>
        </NavigationContainer>
    )
}
export default AppContainer;