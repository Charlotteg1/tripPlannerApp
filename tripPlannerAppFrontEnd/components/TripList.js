import { Button, SafeAreaView , Text} from "react-native"
import { useState } from "react"

const TripList = ({navigation}) =>{

    const [currentTripId, setCurrentTripId] = useState()
    const [futureTripIds, setFutureTripIds] = useState([])
    const [pastTripIds, setPastTripIds] = useState([])


    return(
    <SafeAreaView>
        <Button onPress={()=>navigation.navigate('addTrips')} title="Add Trip"/>
        <Text>View future, current and past trips here</Text>
        {/* add trip option, directs to AddTrip screen*/}
        {/* fetch all trips, search to find current (if) going on against the current date */}
        {currentTripId && <Text>Current Trip</Text>}
        {/* current trip displays , (call trip component)*/}
        {futureTripIds && <Text>Future Trips</Text>}
        {/* future trip displays , in  reverse chronological order , call trip component*/}
        {pastTripIds && <Text>Past Trips</Text>}
    </SafeAreaView>)
}
export default TripList;