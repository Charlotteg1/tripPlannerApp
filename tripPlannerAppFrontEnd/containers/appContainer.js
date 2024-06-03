import { NavigationContainer } from "@react-navigation/native";
import Login from "../components/Login";
import TripList from "../components/TripList";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import AddTrip from "../components/AddTrip";
import IndividualTrip from "../components/IndividualTrip.js";
import PackingList from "../components/PackingList";
import { createContext } from "react";
import { useState } from "react";
const Stack = createNativeStackNavigator();
export const Context = createContext(null);

const AppContainer = () => {
    const [currentUser, setCurrentUser] = useState(null);

    const contextValue={currentUser,setCurrentUser}


    
    return(
        <Context.Provider value={contextValue}>
            <NavigationContainer>
                <Stack.Navigator>
                        <Stack.Screen name="login" component={Login} options={{
                            headerShown: false
                        } } />
                        <Stack.Screen name="trips" component={TripList} options={{
                            headerShown: false
                        }}/>
                        <Stack.Screen name="addTrips" component={AddTrip} options={{
                            headerShown: false
                        }}/>
                        <Stack.Screen name="individualTrip" component={IndividualTrip} options={{
                            headerShown: false
                        }}/>
                        <Stack.Screen name="packingLists" component={PackingList} options={{
                            headerShown: false
                        }}/>
                </Stack.Navigator>
            </NavigationContainer>
        </Context.Provider>
    )
}
export default AppContainer;