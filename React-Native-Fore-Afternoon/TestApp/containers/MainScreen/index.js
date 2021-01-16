import * as React from 'react';
import { Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';



import HomeStackScreen from "../../navigation/HomeNav";

export default function MainScreen() {
  return (
    <NavigationContainer>
      <HomeStackScreen ></HomeStackScreen> 
    </NavigationContainer>
  );
}