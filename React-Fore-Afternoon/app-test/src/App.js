import logo from './logo.svg';
import React,{ Component } from "react";
import './App.css';

import Bottle from './Bottle';
import Data from './Data';

class App extends Component {
  // state = {
  //   data: [
  //     {
  //       id : 1,
  //       name : "Raj",
  //       email : "abc@gmail.com"
  //     },
  //     {
  //       id : 2,
  //       name : "Kesav",
  //       email : "efg@gmail.com"
  //     },
  //     {
  //       id : 3,
  //       name : "Gopal",
  //       email : "ahi@gmail.com"
  //     }
  //   ]
  // } 
  // <Data data = {this.state.data} />
  
  render() {
    console.log(this.state)
    return(
    <div className="App">
      <header>
        <h3>User Data</h3>
        
        
        <Data />
      </header>
    </div>
    );
  }
}

export default App;
