import * as React from 'react';
import { Button, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import TopRated from '../../containers/TopRated';
import DetailsScreen from '../../containers/DetailsScreen';

const TopRatedStack = createStackNavigator();

function TopRatedStackScreen() {
    return (
      <TopRatedStack.Navigator headerMode= "none" >
        <TopRatedStack.Screen name="Home" component={TopRated} />
        <TopRatedStack.Screen name="Details" component={DetailsScreen} />
      </TopRatedStack.Navigator>
    );
  }

  export default TopRatedStackScreen;