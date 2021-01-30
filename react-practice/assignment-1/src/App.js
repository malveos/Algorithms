import React, { Component } from 'react';
import './App.css';

import UserInput from './UserInput/UserInput'
import UserOutput from './UserOutput/UserOutput'
import CharComp from './CharComponent/CharComponent'
import ValidationComp from './ValidationComponent/ValidationComponent'

class App extends Component  {
  state = {
    username:"osm user",
    userInput:''
  };

  userNameChanger = () => {
    this.setState({username: "osm.."});
  }

  userNameBinder = (event) => {
    this.setState({username: event.target.value});
  }

  inputChangeHandler = (event) => {
    this.setState({userInput: event.target.value});
 }

 deleteCharHandler = (i) =>{
    let str = this.state.userInput.split('');
    str.splice(i,1)
    this.setState({userInput:str.join('')})
 }

  render() {
    const style = {
      backgroundColor: 'pale blue',
      font: 'Arial',
      border: '1px solid pink',
      padding: '10px',
      margin: '10px',
      cursor: 'pointer'
    };

    let charList = this.state.userInput.split('').map((c,i) => {
      return <CharComp char={c} key={i} clicked={() =>this.deleteCharHandler(i)}/>
    });

    return (
      <div className="App">
          <UserInput changeName={this.userNameBinder}/>
          <UserOutput style = {style} username="myOwnUsername" />
          <UserOutput username={this.state.username}/>
          <UserOutput username={this.state.username} changepara={this.userNameChanger}/>

          <input type="text" onChange={this.inputChangeHandler}
            value = {this.state.userInput}></input>

          <p>{this.state.userInput}</p>
          <ValidationComp length= {this.state.userInput.length}/>

          {charList}
      </div>
    );
  }
     
  };

export default App;
