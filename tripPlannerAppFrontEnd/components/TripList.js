import { SafeAreaView , Text, Pressable, StyleSheet} from "react-native"
import { useState } from "react"

const TripList = ({navigation}) =>{

    const [trips, setTrips] = useState()
    const [currentTripId, setCurrentTripId] = useState()
    const [futureTripIds, setFutureTripIds] = useState()
    const [pastTripIds, setPastTripIds] = useState()
    const [currentUserId, setCurrentUserId] = useState(2);

    const fetchTrips = async () => {
        const url = `http://localhost:8080/user/authenticate/user/${currentUserId}`;
        const response = await fetch(url);
        const data = await response.json();

        if(response.status === 302){
            setTrips(data);
            return true;
        }else{
            return false;
        }
    }

    useEffect(()=>{
      fetchTrips();
    },[]);



    return(
    <SafeAreaView>
        <Pressable style={styles.addTrip} onPress={()=>navigation.navigate('addTrips')}>
            <Text style={[styles.addTripText, { textAlign: 'center' }]}>Add Trip</Text>
        </Pressable>
        {currentTripId && futureTripIds &&  pastTripIds && <Text>Loading...</Text>} 
        {/* check below if equals null  */}
        {currentTripId && futureTripIds &&  pastTripIds && <Text>You have no trips please add trip to display</Text>} 
        {currentTripId && <Text>Current Trip</Text>}
        {futureTripIds && <Text>Future Trips</Text>}
        {pastTripIds && <Text>Past Trips</Text>}
    </SafeAreaView>)
    }

const styles = StyleSheet.create({
    addTrip: {
        alignSelf: 'center',
        marginTop: 2,
        backgroundColor: '#80DBA1',
        padding: 8,
        borderRadius:10,
        width: 100,
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
    },
    addTripText: {
        fontFamily: 'Courier New'
    },
});
export default TripList;