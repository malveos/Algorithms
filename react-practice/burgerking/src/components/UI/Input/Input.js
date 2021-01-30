import React from 'react';

import classes from './Input.css';

const input = props => {
    let inputElem = null;
    const inputClasses = [classes.InputElem];
    if(props.invalid && props.shouldValidate && props.touched) {
        inputClasses.push(classes.Invalid);
    }

    switch (props.elementType) {
        case ('input'):
            inputElem = <input
                className={inputClasses.join(' ')}
                {...props.elementConfig}
                value={props.value}
                onChange={props.changed} />;
            break;
        case ('textarea'):
            inputElem = <textarea
                className={inputClasses.join(' ')}
                {...props.elementConfig}
                value={props.value}
                onChange={props.changed} />;
            break;
        case ('select'):
            inputElem = <select className={inputClasses.join(' ')}
                {...props.elementConfig}
                value={props.value}
                onChange={props.changed}>
                {props.elementConfig.options.map(op => {
                    return <option
                        key={op.value}
                        value={op.value}>{op.displayValue}</option>;
                })}
            </select>;
            break;
        default:
            inputElem = <input
                className={inputClasses.join(' ')}
                {...props.elementConfig}
                value={props.value}
                onChange={props.changed} />;
            break;
    }

    return (
        <div className={classes.Input}>
            <label>{props.label}</label>
            {inputElem}
        </div>
    );
}

export default input;