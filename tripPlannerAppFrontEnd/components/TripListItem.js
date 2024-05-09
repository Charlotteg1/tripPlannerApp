import { Pressable, SafeAreaView, StyleSheet, Text} from "react-native";

const TripListItem = ({trip, navigation}) => {

    // calculating trip length
    const startDate = new Date(trip.tripStartDate);
    const endDate = new Date(trip.tripEndDate);
    const differenceMs = endDate - startDate;
    const numOfDays = differenceMs / (1000 * 60 * 60 * 24);

    return (
        <SafeAreaView >
            <Pressable style={styles.tripBox} onPress={()=>navigation.navigate('individualTrip' , { viewTrip: trip })}>
                <Text style={styles.destination}>{trip.destination}</Text>
                <Text style={styles.dates}>{trip.tripStartDate} - {trip.tripEndDate}</Text>
                <Text style={styles.tripLength}>{numOfDays} days</Text>
                {/* add > symbol to right */}
            </Pressable>
        </SafeAreaView>
    )
}
const styles = StyleSheet.create({
    tripBox: {
        backgroundColor: 'beige',
        borderRadius:10,
        borderColor: 'navy',
        padding:10,
        margin: 5,
    },
    destination: {
        color: '#80D34E',
        margin: 2,
    },
    dates: {
        margin: 2,
    },
    tripLength: {
        color: 'pink',
        margin: 2,
    }
});
export default TripListItem;

