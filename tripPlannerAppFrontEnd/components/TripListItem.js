import { Pressable, SafeAreaView, StyleSheet, Text} from "react-native";

const TripListItem = ({trip, navigation}) => {

    // calculating trip length
    const startDate = new Date(trip.tripStartDate);
    const endDate = new Date(trip.tripEndDate);
    const differenceMs = endDate - startDate;
    const numOfDays = differenceMs / (1000 * 60 * 60 * 24);

    const formatDate = (dateToFormat) => {
        const date = new Date(dateToFormat);
        const day = String(date.getDate()).padStart(2, '0');
        const month = String(date.getMonth() + 1).padStart(2, '0'); 
        const year = date.getFullYear();
        return `${day}/${month}/${year}`;
      };

    return (
        <SafeAreaView >
            <Pressable style={styles.tripBox} onPress={()=>navigation.navigate('individualTrip' , { trip: trip , numOfDays : numOfDays})}>
                <Text style={styles.destination}>{trip.destination}</Text>
                <Text style={styles.dates}>{formatDate(trip.tripStartDate)} - {formatDate(trip.tripEndDate)}</Text>
                <Text style={styles.tripLength}>{numOfDays} days</Text>
                {/* add > symbol to right */}
            </Pressable>
        </SafeAreaView>
    )
}
const styles = StyleSheet.create({
    destination: {
        color: '#393A41',
        margin: 2,
        fontWeight: '900',
        fontSize: 20,
        fontFamily: 'Courier New',
        textShadowColor: '#9293A0',
        textShadowRadius: 3, 
    },
    dates: {
        margin: 2,
        fontFamily: 'Courier New',
    },
    tripLength: {
        color: 'navy',
        margin: 2,
        fontFamily: 'Courier New',
    },
    tripBox: {
        alignSelf: 'center',
        marginTop: 2,
        backgroundColor: '#A4AA9D',
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

