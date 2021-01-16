
import React from 'react';
import axios from 'axios';
import { View,  Image } from 'react-native';
import { Card, Text, ListItem, Button, Rating } from 'react-native-elements'
import { color } from 'react-native-reanimated';
import {re , getDate, Genre, getMovieDataURL ,getImageURL } from "../../utils/Cards";
import { NavigationContainer } from '@react-navigation/native';
import Icon from 'react-native-vector-icons/FontAwesome';
import { createStackNavigator } from '@react-navigation/stack';

const Stack = createStackNavigator();

class Cards extends React.Component {
  state = {
    moviesDetails : {}
  }
  componentDidMount() {
      const url =  getMovieDataURL(this.props.item.id);
      
      axios.get(url)
          .then(res => {      
            this.setState({ moviesDetails : res.data });
          })
          
    

}
    render() {
       const item = this.state.moviesDetails;
       const index = this.props.index;
       const img_url = getImageURL(item.poster_path);
       return (
           <View style={{
             width: 400,

           }}>
            <Card>
  {

    <View style={{
      flexWrap: 'wrap'
    }}>
        <View key={item.id} style={{flexDirection: 'row'}} >
          
          <Image
            style = {{ width: 100,
              height: 180,
            borderRadius: 5}}
            source={{ uri: img_url}}
          />
          <View style={{flexDirection: 'column',flexShrink: 1}}>
          <Text h4 style = {{marginLeft: 10, flexShrink: 1}}>{item.original_title}</Text>
          <Text style = {{marginLeft: 10}}>{getDate(item.release_date)}</Text>
          <Text style={{marginLeft: 10, fontSize: 15, fontWeight: "bold"}} >Genre: </Text>
          <View style={{flexDirection: 'row'}}> 
        { Genre(item).map((item,index) => {
          return(<Text style={{ marginLeft: 10}}>{item}</Text>);
        }) }</View>
              <Text></Text>
              <View style={{flexDirection: 'row'}}>
              <Text style= {{ marginLeft: 10,
              fontSize: 15 , fontWeight: "bold" }}>Rating: </Text>
              <Text style= {{ marginLeft: 10,
              fontSize: 15, fontWeight: "bold", color: re(item.vote_average) 
              } }>{item.vote_average}</Text> 
              </View>
              
              

              
        </View>
      
        </View>
        
     </View> 
  }
</Card>
           </View>
        
        );
      }

}

export default Cards;