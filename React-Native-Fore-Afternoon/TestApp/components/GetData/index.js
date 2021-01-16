import React from 'react';
import axios from 'axios';
import { View,  ScrollView, Text, FlatList, TouchableOpacity } from 'react-native';
import Cards from '../Cards';
import { SafeAreaView } from 'react-native-safe-area-context';
import {getMovieDataURL} from '../../utils/Cards';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';

const Stack = createStackNavigator();
const  actionOnRow = (item) => {
  console.log('Selected Item :',item);
  this.props.navigation.navigate('Details');
}


class Requests extends React.Component {
  state = {
    movieList: [],
    moviesDetails : []
  }
  constructor(props){
    super(props);
}
  
  
  componentDidMount() {
      const url =  getMovieDataURL(this.props.dom);
    axios.get(url)
      .then(res => {          
        const arrayList = res.data.results;
        
        this.setState({ movieList : arrayList });
      })
      

  }

  render() {
   const arrayList = this.state.movieList;
   const renderItem = ({ item }) => (
    <TouchableOpacity onPress={ () => this.props.navigation.navigate('Details',{itemDeet : item})}>
    <Cards item = {item} ></ Cards>
    </TouchableOpacity>
  );
   
   return (
      
         <ScrollView
              contentInsetAdjustmentBehavior="automatic">
      {/* <View>
        { 
        arrayList.map((item, index)  => {
            return (

            <Cards item = {item} index = {index} ></ Cards>
            );
          })
        }
      </View> */}
      <FlatList
        data={arrayList}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />

      </ScrollView>
      
      
    );
  }
}


export default Requests;