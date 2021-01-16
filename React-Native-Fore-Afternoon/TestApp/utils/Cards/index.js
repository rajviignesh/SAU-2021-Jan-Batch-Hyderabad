import React from 'react';
import { Button } from 'react-native-elements';
import Icon from 'react-native-vector-icons/FontAwesome';

const base_data_url = 'https://api.themoviedb.org/3/movie/';
const base_image_url = "https://image.tmdb.org/t/p/w500" ;
const base_video_url = "https://api.themoviedb.org/3/movie/";
const api = '?api_key=254a6e6fbab8e4795cc99d06f3c814e0&language=en-US';
const api_video = "/videos?api_key=254a6e6fbab8e4795cc99d06f3c814e0&language=en-US"

export function re(num) {
  if(num >8){return "green"}
  else if(num >7){return "#d4ba2a"}
  else {return "red"}
} 



export function getDate(str){
  if (typeof(str) !== 'undefined' && str.length){
    return str.slice(0,4);
  }
}



export function Genre(item){
  if (typeof(item.genres) !== 'undefined' && item.genres.length) {
    const genreArray = [];
    item.genres.map((item, index)  => {
      genreArray.push(item.name);
    })
    if(genreArray.length >3){
      genreArray.pop();
      genreArray.pop();
    }
    return(genreArray);
  }
  else{
    return(["Undefined"]);
  }

}

export function Produce(item){
  if (typeof(item.production_companies) !== 'undefined' && item.production_companies.length) {
    const genreArray = [];
    item.production_companies.map((item, index)  => {
      if(item.name === "null"){
        genreArray.push({name : "Not Available"})
      }
      else{
        genreArray.push(item);
      }
      
    })
    if(genreArray.length >5){
      genreArray.pop();
      genreArray.pop();
      genreArray.pop();
      genreArray.pop();
    }
    else if(genreArray.length >2){
      genreArray.pop();
      genreArray.pop();
    }
    return(genreArray);
  }
  else{
    return(["Undefined"]);
  }

}

export function getImageURL(str){
    const url = base_image_url  + str;
    return url;

}

export function getMovieDataURL(str){
    const url = base_data_url  + str + api;
    return url;

}

export function getTrailerURL(str){
  const url = base_video_url  + str + api_video;
  return url;

}

export function homeButton(navigation){
  return(
    <Button
  icon={
    <Icon
      name="home"
      size={25}
      color="white"
      
    />
  }
  onPress = {() => navigation.navigate('HomeScreen')}

/>
  );

}



