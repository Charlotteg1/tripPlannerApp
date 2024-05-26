import { SafeAreaView, Text, Pressable, StyleSheet } from "react-native";

const IndividualTrip = ({viewTrip, numOfDays, navigation}) => {

    return (
    <SafeAreaView>
        <Pressable style={styles.packingListButton} onPress={()=>navigation.navigate('packingLists')}>
            <Text style={[styles.packingListText, { textAlign: 'center' }]}>View Packing List</Text>
        </Pressable>
        <Text style={styles.destination}>{viewTrip.destination}</Text>
        <Text style={styles.dates}>{viewTrip.tripStartDate} - {viewTrip.tripEndDate}</Text>
        <Text style={styles.tripLength}>{numOfDays} days</Text>
        <Text style={styles.climate}>climate : {viewTrip.climate}</Text>
        {/* Day by day */}
    </SafeAreaView>)
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
});export default IndividualTrip;