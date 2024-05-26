import { SafeAreaView, Pressable } from "react-native";
import { useState } from "react";

const PackingList = ({tripId, navigation}) =>{

    const {allLists, setAllLists} =useState();


    // fetch Packing Lists for Trip
    const fetchPackingLists = async () => {
        const url = `http://localhost:8080/packingLists/trip/${tripId}`;
        const response = await fetch(url);
        const data = await response.json();

        if(response.status === 302){
            setAllLists(data);
            return true;
        }else{
            return false;
        }
    }
    
    // iterate through each list and display Title and items 
    // note each item has an indicator (packed or unpacked)
    // need option to add to list
    // and create new list

    const handleAddList = () => {
        // need pop to allow to enter name and possibly items 
        // pop up 
        //  then save (ie call post request)
    }

    return(
    <SafeAreaView>
        {/* go back to trip page button */}
        <Pressable onPress={()=> navigation.goBack()}>Back</Pressable>
        {/* add new list */}
        <Pressable onPress={()=> handleAddList}> + add new list </Pressable>
    </SafeAreaView>)
}
export default PackingList;