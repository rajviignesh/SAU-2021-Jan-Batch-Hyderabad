/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {SafeAreaView, ScrollView, View, Text, StatusBar} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { MaterialCommunityIcons } from '@expo/vector-icons'; 
import { AntDesign } from '@expo/vector-icons';
import {styles} from './styles';

import {
  Header,
  LearnMoreLinks,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import { SafeAreaProvider } from 'react-native-safe-area-context';

import TopRatedNav from './navigation/TopRatedNav';
import RecentNav from './navigation/RecentNav';
import MostPopularNav from './navigation/MostPopularNav';





const Tab = createBottomTabNavigator();

function App(){
  const data = ["Raj","Raj1","Raj3","Raj4","Raj5","Raj6","Raj7","Raj","Raj1","Raj3","Raj4","Raj5","Raj6","Raj7","Raj","Raj1","Raj3","Raj4","Raj5","Raj6","Raj7"]
  return (
    <>
    <SafeAreaProvider>
      
      <Tab.Navigator
      screenOptions={({ route }) => ({
        tabBarIcon: ({ focused, color, size }) => {
          if (route.name === 'Most Popular') {
            return (
              <MaterialCommunityIcons name="popcorn" size={30} color="black" />
            );
          } else if (route.name === 'Recent') {
            return (
              <AntDesign name="clockcircleo" size={30} color="black" />
            );
          }
          else if (route.name === 'Top Rated') {
            return (
              <AntDesign name="staro" size={30} color="black" />
            );
          }
        },
      })}
      >
          <Tab.Screen name="Most Popular" component={MostPopularNav} />
          <Tab.Screen name="Recent" component={RecentNav} />
          <Tab.Screen name="Top Rated" component={TopRatedNav} />
        </Tab.Navigator>
      
        {/* <ScrollView
          contentInsetAdjustmentBehavior="automatic"
          style={styles.scrollView}>
          <View>
            {data.map((item, index)  => {
              return (<Text style={{
                textAlign: 'center',
                marginVertical:20,
                marginHorizontal:20,
                backgroundColor: "pink"
              }} key={index}>{item}</Text>);
            })
          }
          </View> 
        </ScrollView> */}
      </SafeAreaProvider>
    </>
  );
};

export default App;
