import { Text, SafeAreaView, TextInput, Button } from "react-native";
import { useState, useEffect } from "react";
import Calendar from 'react-native-calendar-datepicker';
import Moment from 'moment';
import RNPickerSelect from 'react-native-picker-select';


const AddTrip = ({navigation}) => {
    const [destinationName, setDesinationName] = useState();
    const [startDate, setStartDate] = useState();
    const [endDate, setEndDate] = useState();
    const [climateChoice, setClimateChoice] = useState();
    const [errorMessage, setErrrorMessage] = useState();

    useEffect(() => {
        if (startDate) {
            setEndDate(null); 
        }
    }, [startDate]);

    const handleStartDatePicked = (date)=>{
        setStartDate(date)
    }

    const handleEndDatePicked = (date)=>{
        setEndDate(date)
    }

    const handleAddTrip = () => {
        // check no null values, if so display error (highlight entry with error in future)
        // make the entries into json format and send to backend (POST request)
        // display pop up to confirm (in future)
        // naviagate back to trips page
        navigation.navigate('trips')
    }


    return(
        <SafeAreaView>
        {/* // name of place (use master list via api possibly) */}
        <Text style={{ fontSize: 34 }}> Desination:</Text>
        <TextInput onChangeText={(text) => setDesinationName(text)} value={destinationName}/>
        {/* // trip start date ( calender set up) */}
        <Text> start date:</Text>
        <Calendar onChange={(date) => handleStartDatePicked(date)}
        selected={startDate}
        // We use Moment.js to give the minimum and maximum dates.
        minDate={Moment().startOf('day')}
        maxDate={Moment().add(1, 'years').startOf('day')}
        />
        {/* // trip end date ( calender set up , also considering entered start date) */}
        <Text> end date:</Text>
        <Calendar onChange={(date) => handleEndDatePicked(date)}
        selected={endDate}
        // We use Moment.js to give the minimum and maximum dates.
        minDate={startDate ? Moment(startDate).startOf('day') : Moment().startOf('day')} 
        maxDate={Moment().add(1, 'years').startOf('day')}
        />
        {/* // climate (enum 5 others ( use images to reflect)) */}
        <Text>Choose Climate:</Text>
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
    />
        <Button onPress={()=> handleAddTrip()} title="Add Trip"/>
        </SafeAreaView>
    )
};
export default AddTrip;