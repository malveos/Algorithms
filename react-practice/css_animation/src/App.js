import React, { Component } from "react";
import Transition from 'react-transition-group/Transition';

import "./App.css";
import Modal from "./components/Modal/Modal";
import Backdrop from "./components/Backdrop/Backdrop";
import List from "./components/List/List";

class App extends Component {
  state = {
    modalIsOpen: false,
    showBlock: true
  }

  showModal = () => {
    this.setState({ modalIsOpen: true });
  }

  closeModal = () => {
    this.setState({ modalIsOpen: false });
  }

  statechange = () => {
    this.setState(prevState => ({
      showBlock: !prevState.showBlock
     }));
  }

  render() {
    const timing = {
      enter: 400,
      exit: 100
    }
    return (
      <div className="App">
        <h1>React Animations</h1>

        <button className="Button" onClick={this.statechange}>Toggle</button>

        <Transition
          in={this.state.showBlock}
          timeout={timing}
          // onEnter={}
          // onEntering={}
          // onEntered={}
          // onExiting={}
          // onExit={}
          // onExited={}
          mountOnEnter unmountOnExit>
          {state => (
            <div style={{
              backgroundColor: 'red',
              width: 100,
              height: 100,
              margin: 'auto',
              transform: 'opacity 1s ease-out',
              opacity: state === 'exited' ? 0 : 1
            }}></div>
          )}
        </Transition>
        <Transition in={this.state.modalIsOpen} timeout={300} mountOnEnter unmountOnExit >
          {state => <Modal show={state} closed={this.closeModal} />}
        </Transition>

        <Backdrop show={this.state.modalIsOpen} />

        <button className="Button" onClick={this.showModal}>Open Modal</button>
        <h3>Animating Lists</h3>
        <List />
      </div>
    );
  }
}

export default App;
