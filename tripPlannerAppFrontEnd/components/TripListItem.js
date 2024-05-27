import { Pressable, SafeAreaView, StyleSheet, Text} from "react-native";

const TripListItem = ({trip, navigation}) => {

    // calculating trip length
    const startDate = new Date(trip.tripStartDate);
    const endDate = new Date(trip.tripEndDate);
    const differenceMs = endDate - startDate;
    const numOfDays = differenceMs / (1000 * 60 * 60 * 24);

    return (
        <SafeAreaView >
            <Pressable style={styles.tripBox} onPress={()=>navigation.navigate('individualTrip' , { viewTrip: trip , numOfDays : numOfDays})}>
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
        backgroundColor: 'light grey',
        borderRadius:10,
        borderColor: 'navy',
        padding:10,
        margin: 5,
    },
    destination: {
        color: '#80D3B6',
        margin: 2,
        fontWeight: '800'
    },
    dates: {
        margin: 2,
    },
    tripLength: {
        color: 'navy',
        margin: 2,
    },
    tripBox: {
        alignSelf: 'center',
        marginTop: 2,
        backgroundColor: 'beige',
        padding: 5,
        borderRadius:10,
        width: '96%',
        shadowOpacity: '0.4%',
        shadowColor: '#775204',
        shadowOffset: { width: 1, height: 3},
        shadowRadius: 7,
    },
});
export default TripListItem;

