import React, { Component }  from 'react';
import {SafeAreaView, ScrollView, View, Button  ,StatusBar} from 'react-native';
import { Text, Header } from 'react-native-elements'
import { SafeAreaProvider } from 'react-native-safe-area-context';
import Requests from "../../components/GetData";
import { homeButton } from "../../utils/Cards";


class TopRated extends Component {
  render(){
    return(<SafeAreaProvider>
    <View style={{ flex: 1,  alignItems: 'center'}}>
    <Header
  placement="center"
  centerComponent={{ text: 'Top Rated', style: {fontSize: 25, fontWeight:"bold", color: '#fff' } }}
  rightComponent={homeButton(this.props.navigation)}/>
        <Requests dom = "top_rated" navigation = {this.props.navigation}/>
      </View>
      </SafeAreaProvider>
    );}
}
export default TopRated;