import React, { Component }  from 'react';
import {SafeAreaView, ScrollView, View, StatusBar} from 'react-native';
import { Text, Header } from 'react-native-elements'
import Requests from "../../components/GetData";
import { homeButton } from "../../utils/Cards";


class MostPopular extends Component  {
  render(){
    return(<View style={{ flex: 1,alignItems: 'center' }}>
        <Header
  placement="center"
  centerComponent={{ text: 'Most Popular', style: { fontSize: 25, fontWeight:"bold",color: '#fff' } }}
  rightComponent={homeButton(this.props.navigation)}
  centerContainerStyle={{
    justifyContent: 'space-around',
  }}/>
        <Requests dom = "popular" navigation = {this.props.navigation} />
      </View>
    );}
}

export default MostPopular;