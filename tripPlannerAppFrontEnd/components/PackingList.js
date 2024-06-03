import { SafeAreaView, Pressable, Text, StyleSheet, Modal, View, TextInput} from "react-native";
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
     
        allLists.forEach((list) => {
            renderedLists.push(
                <SafeAreaView key={list.id}>
                    <IndividualPackingList list={list}/>
                </SafeAreaView>
            );
        });

        renderedLists.push(
            <SafeAreaView>
                    <TextInput placeholder={"enter new item"} value={newItem} onChangeText={(text)=>setNewItem(text)} />
            </SafeAreaView>
        )
        return renderedLists;
    }

    return(
    <SafeAreaView>
        {/* go back to trip page button */}
        <Pressable style={styles.backButton} onPress={()=> navigation.goBack()}>
            <Text style={styles.backText}>
                Back
            </Text>
        </Pressable>
        {/* add new list */}
        {!allLists ? 
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
                            <Text style={styles.closeButtonText} >Close</Text>
                        </Pressable>
                        <TextInput
                            style={styles.inputTitle}
                            placeholder="Enter List Name"
                            value={newListTitle}
                            onChangeText={(e)=> setNewListTitle(e)}
                        />
                        {newListTitle && (newItemsList.map((item, index) => (
                            <TextInput
                                key={index}
                                style={styles.inputItem}
                                placeholder={`Input Item (optional)`}
                                value={item}
                                onChangeText={(value) => handleItemChange(index, value)}
                            />
                        )))}
                        <Pressable style={styles.addButton} onPress={()=>  handleAddList()}>
                            <Text style={styles.addButtonText}>Add List</Text>
                        </Pressable>
                    </View>
                </View>
            </Modal>
    </SafeAreaView>)
};
const styles = StyleSheet.create({
    backButton: {

    },
    backText:{

    },
    nullListText: {

    },
    createFirstListBox: {

    },
    createFirstListText:{

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
        backgroundColor: '#A2A112',
        paddingVertical: 3,
        paddingHorizontal: 8, 
        borderRadius: 5,
    },
    closeButtonText:{

    },
    addButton: {
        backgroundColor: 'beige',
        padding: 10,
        borderRadius: 5,
    },
    addButtonText: {
        color: 'navy',
        fontWeight: '500',
        textAlign: 'center',
    },
    modalBackground: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'rgba(0, 0, 0, 0.5)',
    },
    modalContainer: {
        width: '70%',
        height: '30%',
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
    inputTitle:{
        fontWeight:"600",
    },
    inputItem: {

    },
   
});
export default PackingList;