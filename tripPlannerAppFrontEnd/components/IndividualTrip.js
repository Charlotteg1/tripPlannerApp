import { SafeAreaView, Text, Pressable, StyleSheet, View } from "react-native";
import { useRoute } from '@react-navigation/native';
import EachDay from "./EachDay";

const IndividualTrip = ({navigation}) => {

    const route = useRoute();
    const { trip, numOfDays } = route.params;


    const displayEachDay = () => {
        const days = trip.days;
        return days?.map((day, i) => {
                return (
                <SafeAreaView key={day.id}>
                    <EachDay  day={day} navigation={navigation}/>
                </SafeAreaView>)
            })
    }

    return (
    <SafeAreaView>
        <Pressable style={styles.backButton} onPress={()=>navigation.goBack()}>
            <Text style={[styles.backText, { textAlign: 'center' }]}>Back</Text>
        </Pressable>
        <Pressable style={styles.packingListButton} onPress={()=>navigation.navigate('packingLists', { tripId : trip.id, navigation:navigation})}>
            <Text style={[styles.packingListText, { textAlign: 'center' }]}>View Packing List</Text>
        </Pressable>
        <Text style={styles.tripOverviewHeading}>Trip Overview</Text>
        <View style={styles.overviewBox}>
            <Text style={styles.destination}>{trip.destination}</Text>
            <Text style={styles.dates}>{trip.tripStartDate} - {trip.tripEndDate}</Text>
            <Text style={styles.tripLength}>{numOfDays} days</Text>
            <Text style={styles.climate}>climate : {trip.climate}</Text>
        </View>
        {/* Day by day */}
        <Text style={styles.dayHeading}> Individual Day</Text>
        {displayEachDay()}
    </SafeAreaView>)
}
const styles = StyleSheet.create({
    overviewBox: {
        backgroundColor: 'beige',
        borderBlockColor: 'black',
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