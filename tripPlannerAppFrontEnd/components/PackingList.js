import { SafeAreaView, Pressable, Text, StyleSheet, Modal, View, TextInput, ScrollView} from "react-native";
import { useState, useEffect } from "react";
import IndividualPackingList from "./IndividualPackingList";
import Swipeout from "react-native-swipeout";

const PackingList = ({route, navigation}) =>{

    const { tripId } = route.params;
    const [allLists, setAllLists] = useState();
    const [newListModalOpen, setNewListModalOpen] = useState(false);
    const [newListTitle, setNewListTitle] = useState('');
    const [newItemsList, setNewItemsList] = useState(['']);
    const [newItem, setNewItem] = useState('');

    const handleOpenModal=()=>{
        setNewListModalOpen(true)
    }

    const handleCloseModal=()=>{
        setNewListTitle(null)
        setNewItemsList([''])
        setNewListModalOpen(false)
    }



    // fetch Packing Lists for Trip
    const fetchPackingLists = async () => {
        const url = `http://localhost:8080/packingLists/trip/${tripId}`;
        const response = await fetch(url);
        const data = await response.json();

        if(response.status === 201){
            setAllLists(data);
            return true;
        }else{
            return false;
        }
    }

    useEffect(()=>{
        fetchPackingLists();
      },[]);
    
    // iterate through each list and display Title and items 
    // note each item has an indicator (packed or unpacked)
    // need option to add to list
    // and create new list

    const addNewList = async () => {
        const temp = {
            "listName" : newListTitle
        }
        const url = `http://localhost:8080/packingLists/${tripId}`
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(temp),
        });
        if (response.status === 201) {
            const data = await response.json();
            setAllLists(data)
            await fetchPackingLists()
            setNewListTitle('');
        } else {
            console.error('Failed to add list', response.status, response.statusText);
        }

    }

    const addListItem = async (itemName, listId) => {
        const temp = {
            "itemName" : itemName
        }
        const url = `http://localhost:8080/packingLists/addItem/${listId}`
        const response = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(temp),
        });
        if (response.status === 201) {
            const data = await response.json();
            setAllLists(data)
        } else {
            console.error('Failed to add list', response.status, response.statusText);
        }

    }

    const handleAddList = async () =>{
        // call post method for creating new list
        // in for loop call post for adding each item to list, eventually add to / change back end so can allow a bulk list
        await addNewList()

        // this could possibly cause an error, as not technically correct, need to change back end so that list id is returned
        const listId = allLists[allLists.length].id

        for (const itemName of newItemsList) {
            if(itemName.length > 0){
                await addListItem(itemName, listId)
            }
        }
        setNewItemsList([''])
        handleCloseModal()
    }

    const handleItemChange = (index, value) => {
        const updatedItems = newItemsList.map((item, i) => (i === index ? value : item));
        setNewItemsList(updatedItems);

        if (index === newItemsList.length - 1 && value !== '') {
            setNewItemsList([...updatedItems, '']);
        }
    };

    const displayEachList = () =>{
        const renderedLists = [];
        console.log(allLists)
        allLists.forEach((list) => {
            renderedLists.push(
                <SafeAreaView key={list.id}>
                    <IndividualPackingList list={list}/>
                </SafeAreaView>
            );
        });

        renderedLists.push(
            <SafeAreaView>
                    <TextInput styles={styles.newItemInput} placeholder={"enter new item"} value={newItem} onChangeText={(text)=>setNewItem(text)}/>
                    {newItem && 
                    <Pressable styles={styles.newItemButton}>
                        <Text styles={styles.newItemButtonText}>Enter</Text>
                    </Pressable>
                    }
            </SafeAreaView>
        )
        return renderedLists;
    }

    return(
    <SafeAreaView style={styles.packingListPage}>
        {/* go back to trip page button */}
        <Pressable style={styles.backButton} onPress={()=> navigation.goBack()}>
            <Text style={styles.backText}>
                Back
            </Text>
        </Pressable>
        {/* add new list */}
        {(!allLists)? 
        (<Text style={styles.nullListText}>No packing lists to display please add packing list</Text>)
        :
        (displayEachList())
        }
        
        <Pressable style={allLists ? styles.createFirstListBox: styles.addListBox} onPress={()=> handleOpenModal()}>
            <Text style={allLists ? styles.createFirstListText: styles.addListText}>
                + add new list
            </Text>
        </Pressable>


        <Modal
                animationType="slide"
                transparent={true}
                visible={newListModalOpen}
                onRequestClose={handleCloseModal}
            >
                <View style={styles.modalBackground}>
                    <View style={styles.modalContainer}>
                        <Pressable style={styles.closeButton} onPress={()=> handleCloseModal()}>
                            <Text style={styles.closeButtonText} >X</Text>
                        </Pressable>
                        <TextInput
                            style={styles.inputTitle}
                            placeholder="Enter List Name"
                            value={newListTitle}
                            onChangeText={(e)=> setNewListTitle(e)}
                        />
                        <ScrollView style={styles.inputItemBox}>
                            {newListTitle && (newItemsList.map((item, index) => (
                                <TextInput
                                    key={index}
                                    style={styles.inputItem}
                                    placeholder={`Input Item (optional)`}
                                    value={item}
                                    onChangeText={(value) => handleItemChange(index, value)}
                                />
                            )))}
                        </ScrollView>
                        {newListTitle && <Pressable style={styles.addButton} onPress={()=>  handleAddList()}>
                            <Text style={styles.addButtonText}>Add List</Text>
                        </Pressable>}
                    </View>
                </View>
            </Modal>
    </SafeAreaView>)
};
const styles = StyleSheet.create({
    packingListPage:{
        backgroundColor: '#CCD0C8',
        height: '100%',
        fontFamily: "Courier New",
    },
    backButton: {
        marginTop: 2,
        marginBottom: 5,
        marginHorizontal: '2%',
        backgroundColor: '#45A3A3',
        paddingVertical: 4,
        paddingHorizontal: 10,
        borderRadius:10,
        width: 55,
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
    },
    backText: {
        fontFamily: 'Courier New'
    },
    nullListText: {
        alignSelf: "center",
        top: '20%',
        width: "80%",
        textAlign: 'center',
        fontFamily: 'Courier New',
        fontSize: 20,
        fontWeight: "500",
    },
    createFirstListBox: {
        alignSelf: 'center',
        top: '22%',
        backgroundColor: '#E7CB88',
        paddingVertical: 4,
        paddingHorizontal: 10,
        borderRadius:10,
        width: 200,
        shadowOpacity: '0.2%',
        shadowColor: '#775204',
    },
    createFirstListText:{
        fontSize: 18,
        alignSelf: "center",
        fontFamily: 'Courier New'
    },
    addListBox: {

    },
    addListText: {

    },
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#f0f0f0',
    },
    closeButton: {
        alignSelf: 'flex-start',
        backgroundColor: '#6096BA',
        paddingVertical: 3,
        paddingHorizontal: 10, 
        borderRadius: 16,
    },
    closeButtonText:{
        fontSize: 25,
        fontFamily: 'Courier New'
    },
  
    modalBackground: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'rgba(51, 40, 11, 0.90)',
    },
    modalContainer: {
        width: '75%',
        height: '35%',
        padding: 10,
        backgroundColor: '#fff',
        borderRadius: 10,
        alignItems: 'center',
        shadowColor: '#000',
        shadowOffset: { width: 0,height: 2,},
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5,
    },
    inputItemBox: {
        // alignItems: 'center',
        height: '45%', 
    },
    inputTitle:{
        marginTop: 10,
        fontFamily: "Courier New",
        fontWeight:"600",
        fontSize: 28,
        color: "#484847"
    },
    inputItem: {
        marginTop: 5,
        fontFamily: "Courier New",
        fontWeight:"500",
        fontSize: 18,
        color: "#676765"
    },  
    addButton: {
        backgroundColor: '#93B5DC',
        padding: 10,
        borderRadius: 5,
        borderBlockColor: "#676765",
        bottom: -50
    },
    addButtonText: {
        color: '#2A8EDF',
        fontWeight: '500',
        textAlign: 'center',
        fontFamily: "Courier New",
    },
    newItemInput: {

    },
    newItemButton: {

    },
    newItemButtonText: {

    },


   
});
export default PackingList;