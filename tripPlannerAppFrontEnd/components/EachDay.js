import { SafeAreaView, Text, StyleSheet, View } from "react-native"

const EachDay = ({day, navigation}) => {

    return (
        <SafeAreaView>
            <View style={styles.dayBox}>
                <Text>Day {day.id}</Text>
                {day.accomodation && <Text>{day.accomodation.name}</Text> }
                <Text>Date {day.date}</Text>
            </View>
        </SafeAreaView>
    )
}
const styles = StyleSheet.create({
    dayBox: {
        borderColor: 'black', 
        borderRadius: 10,
        padding:5,
    },   
})
export default EachDay;