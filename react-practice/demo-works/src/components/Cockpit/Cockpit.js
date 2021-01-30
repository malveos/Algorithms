import React, {useEffect, useRef, useContext} from 'react';
import classes from './CockPit.css'
import AuthContext from '../../context/authContext'

const CockPit = (props) =>{

    const toggler = useRef(null);
    const context = useContext(AuthContext);
    useEffect(()=>{
        console.log('[CockPit.js] useEffect called.');
        const timer = setTimeout(()=>{
            //alert('Data saved to cloud.{Persons object updated}');
        }, 1000);
        return ()=>{
            console.log('[CockPit.js] Cleaning after useEffect');
            clearTimeout(timer);
        };
    }, [props.persons]); // executes for only persons change

    useEffect(()=>{
        console.log('[CockPit.js] useEffect called.');
        return ()=>{
            console.log('[CockPit.js] Cleaning after 2nd useEffect');
        };
    });
    let assignedClasses = [];
    let btnClass ='';
    if(props.show) {
         btnClass = classes.red;
    }
   
    if(props.len <=2) {
        assignedClasses.push(classes.red);
    }

    if(props.len <=1) {
        assignedClasses.push(classes.bold);
    }

    return (
        <div className={classes.CockPit}>
            <h1>{props.title}</h1>
            <p  className={assignedClasses.join(' ')}>It is working !!!</p>
            <button className={btnClass} onClick={props.toggleHandler}>{props.btnName}</button><br></br>
            <button ref={toggler} onClick={() => props.switchHandler(1,'Thor')}>Switch</button>
            {/* <AuthContext.Consumer>
                { context=><button onClick={context.login}>Login</button>}
            </AuthContext.Consumer>             */}
            <button onClick={context.login}>Login</button>
            <button disabled={props.disable} onClick={() => props.adder('Thor')}>Add Person</button>
        </div>        
    );
};

export default CockPit;