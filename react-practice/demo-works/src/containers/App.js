import React, { Component } from 'react';
//import Radium , {StyleRoot} from 'radium'
import classes from './App.css';
import Persons from '../components/Persons/Persons'
import CockPit from '../components/Cockpit/Cockpit'
import WithClass from '../hoc/WithClass'
import Aux from '../hoc/AuxiFile'
import AuthContext from '../context/authContext'

class App extends Component {

  constructor(props) {
    super(props);
    console.log('[App.js] Contructor called')
    this.state = {
      persons: [
        { id: 1, name: 'Omkar', age: 12 },
        { id: 2, name: 'Laddya', age: 23 },
        { id: 3, name: 'Raju', age: 15 },
        { id: 4, name: 'Sonu', age: 45 }
      ],
      show:false,
      buttonname: 'Show',
      authenticated: false
    }
  }
  
  componentDidMount() {
    console.log('[App.js] componentDidMount called.');
  }

  componentWillMount() {
    console.log('[App.js] componentWillMount called.');
  }

  switchHandler = (index, newName) => {
    const ps = [...this.state.persons];
    if(ps[index]) {
      ps[index].name = newName
    }
    this.setState({
      persons: ps
    })
  }

  onChangeHandler = (event, index) => {
    const ps = [...this.state.persons];
    if(ps[index]) {
      ps[index].name = event.target.value
    }
    
    this.setState({
      persons: ps
    })
  }

  deletePersonHandler = (i) => {
    const p = this.state.persons;
    p.splice(i,1)
    this.setState({persons: p});
  }

  addPersonHandler = (nm) => {
    const p = this.state.persons;
    let idL = p.length + 2;
    p.push({ id: idL, name: nm, age: Math.floor(Math.random() * 30) + 1 });
    this.setState({persons: p});
  }

  toggleHandler = () => {
    this.setState({
      show: !this.state.show,
      buttonname: !this.state.show?'Hide':'Show'
    });
  }

  loginHandler = () => {
    this.setState({authenticated:true})
  }

  render() {

    let persons = null;
    if (this.state.show) {
          persons = (
          <div>
            <Persons persons={this.state.persons} 
            clicked={this.deletePersonHandler}
            changed={this.onChangeHandler}></Persons>
          </div>
        );
    }

    return (
      //<StyleRoot>
      //<WithClass classes={classes.App}>
      <Aux>
        <AuthContext.Provider value={{
              authenticated:this.state.authenticated,
              login: this.loginHandler}}>
        <CockPit 
          title={this.props.title}
          show={this.state.show}  
          disable={this.state.persons.length>=3}
          persons= {this.state.persons}
          len={this.state.persons.length}
          btnName={this.state.buttonname}
          toggleHandler={this.toggleHandler}
          switchHandler={this.switchHandler}
          adder={this.addPersonHandler} />
        {persons}
        </AuthContext.Provider>        
      </Aux>
      //</WithClass>
      //</StyleRoot>
    );
    //return React.createElement('div', {className: 'App'}, React.createElement('h1',null, 'Welcome to React Omkar'));
  }
}

export default WithClass(App, classes.App);
//export default Radium(App);


//////////////////////////////////////// Using Hook
  // const app = props => {

  //   const [personStates, setPersonState] = useState(
  //     {
  //       persons : [
  //           {name : 'Omkar'},
  //           {name : 'Laddya'},
  //           {name : 'Raju'},
  //           {name : 'Sonu'}
  //       ],
  //       otherState :"other State"
  //     }    
  //   );

  //   const [otherState, setOtherState] = useState('Some state')
  // console.log(personStates, otherState);

  //   const switchHandler = () => {
  //     setPersonState({
  //       persons : [
  //         {name : 'Soni'},
  //         {name : 'Rani'},
  //         {name : 'Dolly'},
  //         {name : 'Sheri'}
  //     ]
  //     })
  //   };
  //     return (
  //       <div className="App">   
  //           <h1 className="App-title">Welcome to React Omkar</h1>
  //           <p>It is working !!!</p>
  //           <button onClick = {switchHandler}>Switch</button>

  //           <Person name={personStates.persons[0].name}/>
  //           <Person name={personStates.persons[1].name}/>
  //           <Person name={personStates.persons[2].name}>Hobby: Chess</Person>
  //           <Person name={personStates.persons[3].name}/>
  //       </div>
  //     );
  //     //return React.createElement('div', {className: 'App'}, React.createElement('h1',null, 'Welcome to React Omkar'));
  // }
  // let c = app;