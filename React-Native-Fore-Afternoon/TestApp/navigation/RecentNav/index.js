import * as React from 'react';
import { Button, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import Recent from '../../containers/Recent';
import DetailsScreen from '../../containers/DetailsScreen';

const RecentStack = createStackNavigator();

function RecentStackScreen() {
    return (
      <RecentStack.Navigator headerMode= "none">
        <RecentStack.Screen name="Home" component={Recent} />
        <RecentStack.Screen name="Details" component={DetailsScreen} />
      </RecentStack.Navigator>
    );
  }

  export default RecentStackScreen;