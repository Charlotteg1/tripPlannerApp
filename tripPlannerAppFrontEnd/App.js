import AppContainer from './containers/AppContainer';
import React from 'react';
import { View } from 'react-native';
import { styles } from './styles';

function App() {
  return (
    <View style={styles.app}>
    <AppContainer/>
    </View>
  );
}
export default App;

