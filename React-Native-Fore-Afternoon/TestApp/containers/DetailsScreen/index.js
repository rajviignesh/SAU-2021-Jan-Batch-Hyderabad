import React, { Component }  from 'react';
import {SafeAreaView, ScrollView, View, Image ,StatusBar} from 'react-native';
import { Card, Text, ListItem, Button, Rating } from 'react-native-elements'
import axios from 'axios';
import {  Header } from 'react-native-elements'
import { SafeAreaProvider } from 'react-native-safe-area-context';
import Requests from "../../components/GetData";
import YouTube from 'react-native-youtube';
import {re , getDate, Produce , Genre, getMovieDataURL ,getImageURL, getTrailerURL } from "../../utils/Cards";



class DetailsScreen extends Component {
  state = {
    moviesDetails : {},
    movieId : ''
  }
  componentDidMount() {
      const url =  getMovieDataURL(this.props.route.params.itemDeet.id);
      
      axios.get(url)
          .then(res => {      
            this.setState({ moviesDetails : res.data });
          })

          const vid_url = getTrailerURL(this.props.route.params.itemDeet.id);
          axios.get(vid_url)
            .then(res => {     
              const arrayList = res.data.results;   
              this.setState({ movieId : arrayList[0].key});
            })
        }
  render(){
    const item = this.state.moviesDetails;
    console.log("Test",this.state.movieId);
    return(
      <ScrollView>
        <View style={{ flex: 1,  alignItems: 'center' }}>
      <Text>Details!</Text>
      
      <Card>
  {

    <View style={{
      flexWrap: 'wrap'
    }}>
        <View key={item.id} style={{flexDirection: 'column'}} >
          <View style = {{alignContent: "center"}}>
          <Image
            style = {{ width: 380,
              height: 180,
            borderRadius: 5}
           }
            source={{ uri: getImageURL(item.backdrop_path)}}
          />
          </View>
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
              <Text></Text>
              <Text style={{marginLeft: 10, fontSize: 15, fontWeight: "bold"}} >Synopsis: </Text>
              <Text style={{ marginLeft: 30}}>{item.overview}</Text>
              <Text style={{marginLeft: 10, fontSize: 15, fontWeight: "bold"}} >Produced by: </Text>
        
              <View style={{flexDirection: 'row', flexShrink: 1}}> 
              { Produce(item).map((item,index) => {
                return( <View style= {{alignItems: "center"}}>
                
                <Image
                    style = {{ width: 50,
                      resizeMode: 'contain',
                      height: 50,
                      marginTop: 5,
                    borderRadius: 5}
                  }
                    source={{ uri: getImageURL(item.logo_path)}}
                  />
                  <Text style={{ fontSize: 10,marginLeft: 10}}>{item.name}</Text>
                  
                 </View> );
              }) }</View>
               <Text style={{marginVertical: 10,marginLeft: 10, fontSize: 15, fontWeight: "bold"}} >Watch Trailer: </Text>
              <YouTube
                      apiKey = "AIzaSyC6djToI88M2X5ZkNzlJd98NYLDDJ-evcg"
                      videoId= {this.state.movieId} // The YouTube video ID
                      loop // control whether the video should loop when ended
                      onReady={e => this.setState({ isReady: true })}
                      onChangeState={e => this.setState({ status: e.state })}
                      onChangeQuality={e => this.setState({ quality: e.quality })}
                      onError={e => this.setState({ error: e.error })}
                      style={{ alignSelf: 'stretch', height: 200 }}
                    />
              
        </View>
        <View style={{flexDirection: 'row', alignItems: "flex-end"}}>
              <Button
                buttonStyle ={{
                  width: 38,
                  height: 38,
                  marginTop: 20,
                  marginLeft: 20,
                  borderRadius: 20
                }}
                  icon={{
                    name: "arrow-left",
                    size: 16,
                    color: "white"
                  }}
                  onPress = {() => this.props.navigation.goBack()}
                 />
              </View>
        </View>
        
     </View> 
  }
</Card>
    </View>
    </ScrollView>
    );}
}
export default DetailsScreen;