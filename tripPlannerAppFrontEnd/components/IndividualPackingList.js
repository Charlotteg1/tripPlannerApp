import { useState, useEffect } from "react";
import { StyleSheet, Text, SafeAreaView} from "react-native";

const IndividualPackingList = ({list}) => {

    // const [listItems, setListItems] = useState()

    // const fetchListItems = async () => {
    //     const url = `http://localhost:8080/packingLists/itemsInList/${list.id}`;
    //     const response = await fetch(url);
    //     const data = await response.json();

    //     if(response.status === 302){
    //         setListItems(data);
    //         console.log(data)
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }

    // useEffect(()=>{
    //     fetchListItems();
    //   },[]);

    const displayItems = () =>{
        const listItems = list.items
        const allItems = [];
    
        listItems.forEach((item) => {
            allItems.push(
                <SafeAreaView key={item.id}>
                    <Text style={styles.item}>{item.itemName}</Text>
                </SafeAreaView>
            );
        });
        return allItems;
    };


    return(
        <SafeAreaView>
            <Text style={ styles.listTitle}>{list.listName}</Text>
            {displayItems()}
        </SafeAreaView>
    )
}; 
const styles = StyleSheet.create({
    listTitle: {
        marginTop: 10,

    },
    item: {

    },
});
export default IndividualPackingList;