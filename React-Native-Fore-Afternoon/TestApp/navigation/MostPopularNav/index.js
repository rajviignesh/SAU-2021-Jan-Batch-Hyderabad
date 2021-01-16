import * as React from 'react';
import { Button, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import MostPopular from '../../containers/MostPopular';
import DetailsScreen from '../../containers/DetailsScreen';

const MostPopularStack = createStackNavigator();

function MostPopularStackScreen() {
    return (
      <MostPopularStack.Navigator headerMode= "none">
        <MostPopularStack.Screen name="Home" component={MostPopular} />
        <MostPopularStack.Screen name="Details" component={DetailsScreen} />
      </MostPopularStack.Navigator>
    );
  }

  export default MostPopularStackScreen;