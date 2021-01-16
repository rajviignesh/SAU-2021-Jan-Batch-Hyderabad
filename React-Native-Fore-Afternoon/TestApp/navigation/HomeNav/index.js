import * as React from 'react';
import { Button, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import HomeScreen from '../../containers/HomeScreen';
import App from '../../App';

const HomeStack = createStackNavigator();

function HomeStackScreen() {
    return (
      <HomeStack.Navigator headerMode= "none">
        <HomeStack.Screen name="HomeScreen" component={HomeScreen} />
        <HomeStack.Screen name="App" component={App} />
      </HomeStack.Navigator>
    );
  }

  export default HomeStackScreen;