import { SafeAreaView , View,  Text, Pressable, StyleSheet} from "react-native";
import { useState, useEffect, useRoute} from "react";
import TripListItem from './TripListItem';

const TripList = ({route, navigation}) =>{
    const {currentUser} = route.params;
    const [trips, setTrips] = useState()
    const [currentTrip, setCurrentTrip] = useState()
    const [futureTrips, setFutureTrips] = useState([])
    const [pastTrips, setPastTrips] = useState([])

    const fetchTrips = async () => {
        const url = `http://localhost:8080/trip/user/${currentUser.id}`;
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
        currentDate.setHours(0, 0, 0, 0);

        if(trips){
            trips.forEach(trip => {
                const tripStartDate = new Date(trip.tripStartDate);
                const tripEndDate = new Date(trip.tripEndDate);
                tripStartDate.setHours(0, 0, 0, 0);
                tripEndDate.setHours(0, 0, 0, 0);

                if (tripEndDate < currentDate){
                    pastTripsArray.push(trip);
                }else if (tripStartDate > currentDate){
                    futureTripsArray.push(trip);
                }else{
                    currentTripHolder = trip
                }
            })
            
            setCurrentTrip(currentTripHolder)
            setFutureTrips(futureTripsArray)
            setPastTrips(pastTripsArray)
        }
    };

    useEffect(() => {
        sortTrips();
    }, [trips]);

    const displayTrips = (tripsToDisplay) => {
        if(tripsToDisplay.length >1 ){
            tripsToDisplay.sort((a, b) => new Date(a.tripEndDate) - new Date(b.tripEndDate));
            console.log(tripsToDisplay)
        }
        
        return tripsToDisplay?.map((trip) => {
                return (
                <SafeAreaView   key={trip.id}>
                    <TripListItem trip={trip} navigation={navigation}/>
                </SafeAreaView>)
            })
    }


    return(
    <SafeAreaView>
        <View style={styles.navigate}>
        <Pressable style={styles.addTrip} onPress={()=>navigation.goBack()}>
            <Text style={[styles.addTripText, { textAlign: 'center' }]}>Back</Text>
        </Pressable>
        {!currentUser ? 
        (<Text></Text>) : 
        (<Pressable style={styles.addTrip} onPress={()=>navigation.navigate('addTrips' , {fetchTrips: fetchTrips})}>
            <Text style={[styles.addTripText, { textAlign: 'center' }]}>Add Trip</Text>
        </Pressable>)}
        </View>
        {/* check below if equals null  */}
        {!currentUser ? 
        (<Text>Loading</Text>) : 
        (<>
        {!currentTrip && !futureTrips &&  !pastTrips && <Text style={styles.noTripText}>You have no trips please add trip to display</Text>} 
        {currentTrip && (<>
            <Text style={[styles.tripHeadings, { fontWeight: 'bold' }]}>Current Trip</Text>
            {displayTrips([currentTrip])}
            </>
        )}
        {futureTrips.length!=0 && (<>
            <Text style={styles.tripHeadings}>Future Trips</Text>
            {displayTrips(futureTrips)}
            </>
        )}
        {pastTrips.length!=0 && (<>
            <Text style={styles.tripHeadings}>Past Trips</Text>
            {displayTrips(pastTrips)}
            </>
        )}
        </>)}
    </SafeAreaView>)
    }

const styles = StyleSheet.create({
    navigate: {
        flexDirection: 'row',
        width: '100%',
        justifyContent: 'space-between'
    },
    addTrip: {
        alignSelf: 'center',
        marginTop: 2,
        marginBottom: 5,
        marginHorizontal: '2%',
        backgroundColor: '#45A3A3',
        paddingVertical: 4,
        paddingHorizontal: 10,
        borderRadius:10,
        width: 'auto',
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
    },
    addTripText: {
        fontFamily: 'Courier New'
    },
    tripHeadings: {
        marginTop: 13,
        marginBottom: 3,
        marginLeft: '2%',
        fontFamily: 'Courier New',
        fontWeight: '600',
        fontSize: 20,
        color: '#403423'
    },
    noTripText: {
        alignSelf: 'center',
        fontFamily: 'Courier New'
    }
   
});
export default TripList;