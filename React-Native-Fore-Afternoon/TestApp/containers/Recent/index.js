import React, { Component }  from 'react';
import {SafeAreaView, ScrollView, View,  StatusBar} from 'react-native';
import { Text, Header } from 'react-native-elements'
import { homeButton } from "../../utils/Cards";
import Requests from "../../components/GetData";


class Recent extends Component {
  render(){
    return(<View style={{ flex: 1, alignItems: 'center' }}>
        <Header
  placement="center"
  centerComponent={{ text: 'Recent', style: { fontSize: 25, fontWeight:"bold",color: '#fff' } }}
  rightComponent={homeButton(this.props.navigation)}/>
        <Requests dom = "upcoming" navigation = {this.props.navigation} />
      </View>
    );}
}

export default Recent;