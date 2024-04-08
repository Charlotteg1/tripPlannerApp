import { Text, SafeAreaView, TextInput } from "react-native";
import { useState, useEffect } from "react";
import Calendar from 'react-native-calendar-datepicker';
import Moment from 'moment';


const AddTrip = () => {
    const [destinationName, setDesinationName] = useState();
    const [startDate, setStartDate] = useState();
    const [endDate, setEndDate] = useState();

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
        <Text>Add trip</Text>
        </SafeAreaView>
    )
};
export default AddTrip;