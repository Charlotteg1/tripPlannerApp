import { StyleSheet, Text, SafeAreaView} from "react-native";
import Swipeout from "react-native-swipeout";

const IndividualPackingList = ({list}) => {

    const handleDelete = () =>{
        console.log(true)
    }

    const handlePacked  = () => {
        // call method 
    }

    const displayItems = () =>{
        const listItems = list.items
        const allItems = [];
        const swipeoutButtonRight = [
            {
                text: 'Delete',
                backgroundColor: 'red',
                onPress: () => handleDelete(),
            }
        ];
        const swipeoutButtonLeft = [
            {
                text: 'packed',
                backgroundColor: 'navy',
                onPress: () => handlePacked(),
            }
        ];
    
        listItems.forEach((item) => {
            allItems.push(
                <Swipeout key={list.id} right={swipeoutButtonRight} left={swipeoutButtonLeft} autoClose={true} style={styles.swipe}>
                    <SafeAreaView key={item.id}>
                        <Text style={styles.item}>{item.itemName}</Text>
                    </SafeAreaView>
                </Swipeout>
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