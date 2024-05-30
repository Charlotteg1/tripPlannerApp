import { Text, SafeAreaView, TextInput, Button, StyleSheet, Pressable, View } from "react-native";
import { useState, useEffect} from "react";
import Calendar from 'react-native-calendar-datepicker';
import { useRoute } from '@react-navigation/native';
import Moment from 'moment';
import RNPickerSelect from 'react-native-picker-select';



const AddTrip = ({navigation}) => {
    const route = useRoute();
    const { fetchTrips } = route.params;
    const [destinationName, setDestinationName] = useState();
    const [startDate, setStartDate] = useState();
    const [endDate, setEndDate] = useState();
    const [minDate, setMinDate] = useState(Moment().startOf('day'));
    const [climateChoice, setClimateChoice] = useState();
    const [errorMessage, setErrorMessage] = useState();

    useEffect(() => {
        if (startDate) {
            setMinDate(Moment(startDate).startOf('day'));
            setEndDate(null); 
        }
    }, [startDate]);

    const handleStartDatePicked = (date)=>{
        setStartDate(date)
    }

    const handleEndDatePicked = (date)=>{
        setEndDate(date)
    }

    const handleAddTrip = async () => {
        // check no null values, if so display error (highlight entry with error in future)
        if(destinationName && climateChoice && startDate && endDate){
            await addNewTrip()
            fetchTrips()
            navigation.navigate('trips')
            
        }
        // make the entries into json format and send to backend (POST request)
        // display pop up to confirm (in future)
        // naviagate back to trips page

    }

    const addNewTrip = async () => {
        temp={
            "userId": 2,
            "destination" : destinationName,
            "tripStartDate": startDate,
            "tripEndDate": endDate,
            "climate": climateChoice

        }
        const url = `http://localhost:8080/trip/addTrip`;
        const response = await fetch(url, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(temp)
        });
        console.log(response)
        if (response.status === 201) {
            return true;
        } else {
            return false;
        }
      };


    return(
        <SafeAreaView style={styles.addTripPage}>
            <Pressable style={styles.backButton} onPress={()=>navigation.goBack()}>
                <Text style={[styles.backButtonText, { textAlign: 'center' }]}>Back</Text>
            </Pressable>
        {/* // name of place (use master list via api possibly) */}
        <View style={styles.destinationSection}>
            <Text style={styles.destinationText}>Desination:</Text>
            <TextInput style={styles.destinationInput} onChangeText={(text) => setDestinationName(text)} value={destinationName} placeholder={'New York, Capri ... '} />
        </View>

        {/* // climate (enum 5 others ( use images to reflect)) */}
        <View style={styles.climateSection}>
            <Text style={styles.climateText}>Choose Climate:</Text>
            <View style={styles.climatePicker}>
                <RNPickerSelect
                onValueChange={(value) => setClimateChoice(value)}
                placeholder={{ label: "Select a Climate", value: null }}
                items={[
                    { label: 'Hot', value: 'Hot' },
                    { label: 'Warm', value: 'Warm' },
                    { label: 'Mild', value: 'Mild' },
                    { label: 'Chilly', value: 'Chilly' },
                    { label: 'Baltic', value: 'Baltic' },
                ]}
                textInputProps={{
                    style: {
                      fontFamily: 'Courier New', 
                      color: '#483247',
                      fontSize: 18,
                      fontWeight: 'bold',
                    },
                }}
                />
            </View>
        </View>

        {/* // trip start date ( calender set up) */}
        <Text style={styles.startText}> Start Date: </Text>
        <View style={styles.startPicker}>
        <Calendar 
        onChange={(date) => handleStartDatePicked(date)}
        selected={startDate}
        minDate={Moment().startOf('day')}
        maxDate={Moment().add(1, 'years').startOf('day')}
        />
        </View>

        {/* // trip end date ( calender set up , also considering entered start date) */}
        <Text style={styles.endText}> End Date:</Text>
        <View style={styles.endPicker}>
        <Calendar 
        onChange={(date) => handleEndDatePicked(date)}
        selected={endDate}
        minDate={minDate} 
        maxDate={Moment().add(1, 'years').startOf('day')}
        />
        </View>
        <Pressable style={styles.addTripButton} onPress={()=> handleAddTrip()}>
            <Text style={styles.addTripText} >Add Trip</Text>
        </Pressable>
        </SafeAreaView>
    )
}
const styles = StyleSheet.create({
    addTripPage:{
        backgroundColor: '#D6D9D3',
        height: '100%',
        fontFamily: 'Courier New',
        flex: 1,
    },
    backButton: {
        alignSelf: 'left',
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
    backButtonText: {
        fontFamily: 'Courier New'
    },

    destinationSection: { 
        flexDirection: 'row',
        width: '95%',
        height: '5%',
        alignItems: 'center'
    },
    destinationText: { 
        color: '#26262C',
        fontSize: 24,
        fontFamily: 'Courier New',
        marginLeft: 8,
    },
    destinationInput: {
        flex: 1,
        fontSize: 23,
        borderRadius: 3,
        paddingLeft: 4,
        borderColor: '#CCD0C8',
        borderWidth: 2,
        fontFamily: 'Courier New',
    },

    climateSection:{
        flexDirection: 'row',
        width: '95%',
        height: '5%',
        alignItems: 'center'
    },
    climateText:{
        fontSize: 18,
        fontFamily: 'Courier New',
        marginLeft: 8,
        marginTop: 20, 
    },
    climatePicker: {
        flex: 1,
        marginTop: 20, 
        color: '#E3C16F'
    },

    startText: {
        fontSize: 18,
        fontFamily: 'Courier New',
        marginLeft: -2,
        marginTop: 20,
    },
    endText: {
        fontSize: 18,
        fontFamily: 'Courier New',
        marginLeft: -2,
        marginTop: 20,
    },
    startPicker : {
        height: 280,
        paddingHorizontal: 10,
    },
    endPicker : {
        height: 280,
        paddingHorizontal: 10,
    },

    addTripButton: {
        alignSelf: 'center',
        marginTop: 2,
        marginBottom: 5,
        marginHorizontal: '2%',
        backgroundColor: '#45A3A3',
        paddingVertical: 7,
        paddingHorizontal: 15,
        borderRadius:10,
        width: 'auto',
        shadowOpacity: '0.2%',
        shadowColor: '#775204'
    },
    addTripText: {
        fontFamily: 'Courier New',
        fontWeight: 'bold',
        fontSize: 20,
        alignSelf: 'center',
    }
}); export default AddTrip;