import React, { Component }  from 'react';
import {ImageBackground,  View, Image , Text,StatusBar} from 'react-native';
import { LogBox } from 'react-native';
import {  Header, Button } from 'react-native-elements'
import { color } from 'react-native-reanimated';
import Requests from "../../components/GetData";
import { homeButton } from "../../utils/Cards";





function HomeScreen({ navigation }) {
    LogBox.ignoreAllLogs();
    return (
        
        <ImageBackground source={require('../../images/bg.png')} style = {{flex: 1,
            resizeMode: "cover",
            justifyContent: "center"}}>
                <StatusBar translucent backgroundColor="transparent" />
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>

        
        <Image source={require('../../images/LOGO.png')}
        style = {{ width: 350, height: 40 }} />
        <Image source={require('../../images/submit.png')}
        style = {{ width: 300, resizeMode: 'contain', height: 40 }} />
        
      <Button
        type="clear"
          title="Login"
          onPress={() => navigation.navigate('App')}
          titleStyle = {{
              color : "white"
          }}
        />
      
      </View>
      
      </ImageBackground>
    );
  }

export default HomeScreen;