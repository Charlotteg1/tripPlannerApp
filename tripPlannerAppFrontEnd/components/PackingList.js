import { SafeAreaView, Pressable, Text, StyleSheet, Modal, View} from "react-native";
import { useState } from "react";

const PackingList = ({tripId, navigation}) =>{

    const {allLists, setAllLists} =useState();
    const [newListModalOpen, setNewListModalOpen] = useState(false);

    const handleOpenModal=()=>{
        console.log('true')
        setNewListModalOpen(true)
    }

    const handleCloseModal=()=>{
        setNewListModalOpen(false)
    }



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

    return(
    <SafeAreaView>
        {/* go back to trip page button */}
        <Pressable style={styles.backButton} onPress={()=> navigation.goBack()}>
            <Text style={styles.backText}>
                Back
            </Text>
        </Pressable>
        {/* add new list */}
        {!allLists && <Text style={styles.nullListText}>No packing lists to display please add packing list</Text>}
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
                        <Text style={styles.modalText}>List Name</Text>
                        <Text> </Text>
                        <Pressable style={styles.addButton} onPress={handleCloseModal}>
                            <Text style={styles.addButtonText}>Close</Text>
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
    button: {
        backgroundColor: 'beige',
        padding: 10,
        borderRadius: 5,
    },
    buttonText: {
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
    modalText: {
        marginBottom: 15,
        textAlign: 'center',
    },
   
});
export default PackingList;