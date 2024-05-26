import { SafeAreaView , Text, Pressable, StyleSheet} from "react-native";
import { useState, useEffect} from "react";
import TripListItem from './TripListItem';

const TripList = ({navigation}) =>{

    const [trips, setTrips] = useState()
    const [currentTrip, setCurrentTrip] = useState()
    const [futureTrips, setFutureTrips] = useState([])
    const [pastTrips, setPastTrips] = useState([])
    const [currentUser, setCurrentUser] = useState(2);

    const fetchTrips = async () => {
        const url = `http://localhost:8080/trip/user/${currentUser}`;
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

    const sortTrips = () =>{
        // need to go through each trip and add to either current, past, upcoming
        const futureTripsArray = [];
        const pastTripsArray = [];
        let currentTripHolder = null;
        const currentDate = new Date();
        if(trips){
            trips.forEach(trip => {
                const tripStartDate = new Date(trip.tripStartDate);
                const tripEndDate = new Date(trip.tripEndDate);

                if (tripStartDate < currentDate){
                    futureTripsArray.push(trip);
                }else if (tripEndDate > currentDate){
                    pastTripsArray.push(trip);
                }else{
                    currentTripHolder = trip
                }
            })
            
            setCurrentTrip(currentTripHolder)
            setFutureTrips(futureTripsArray)
            setPastTrips(pastTripsArray)
            console.log(futureTripsArray)
            console.log(pastTripsArray)
        }
    };

    useEffect(() => {
        sortTrips();
    }, [trips]);

    const displayTrips = (tripsToDisplay) => {
        console.log("mapping trips to display")
        return tripsToDisplay?.map((trip) => {
            console.log(trip)
                return (
                <SafeAreaView key={trip.id}>
                    <TripListItem trip={trip} navigation={navigation}/>
                </SafeAreaView>)
            })
    }


    return(
    <SafeAreaView>
        <Pressable style={styles.addTrip} onPress={()=>navigation.navigate('addTrips')}>
            <Text style={[styles.addTripText, { textAlign: 'center' }]}>Add Trip</Text>
        </Pressable>
        {currentTrip && futureTrips &&  pastTrips && <Text>Loading...</Text>} 
        {/* check below if equals null  */}
        {!currentTrip && !futureTrips &&  !pastTrips && <Text>You have no trips please add trip to display</Text>} 
        {currentTrip && (<>
            <Text style={styles.}>Current Trip</Text>
            {displayTrips([currentTrip])}
            </>
        )}
        {futureTrips.length!=0 && (<>
            <Text>Future Trips</Text>
            {displayTrips(futureTrips)}
            </>
        )}
        {pastTrips.length!=0 && (<>
            <Text>Past Trips</Text>
            {displayTrips(pastTrips)}
            </>
        )}
    </SafeAreaView>)
    }

const styles = StyleSheet.create({
    addTrip: {
        alignSelf: 'center',
        marginTop: 2,
        backgroundColor: '#30DBE2',
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