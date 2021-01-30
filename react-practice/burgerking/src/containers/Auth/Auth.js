import React, { useEffect, useState } from 'react';
import { connect } from 'react-redux';
import { Redirect } from 'react-router';

import Input from '../../components/UI/Input/Input';
import Button from '../../components/UI/Button/Button';
import * as actions from '../../store/actions/auth';
import Spinner from '../../components/UI/Spinner/Spinner';
import classes from './Auth.css';
import { updateObject, checkValidity } from '../../shared/utility';

const auth = props => {

    const [controls, setControls] = useState({
        email: {
            elementType: 'input',
            elementConfig: {
                type: 'email',
                placeholder: 'Mail Address'
            },
            value: '',
            validation: {
                required: true,
                isEmail: true
            },
            valid: false,
            touched: false
        },
        password: {
            elementType: 'input',
            elementConfig: {
                type: 'password',
                placeholder: 'Password'
            },
            value: '',
            validation: {
                required: true,
                minLength: 6
            },
            valid: false,
            touched: false
        }
    });

    const [buttonName, setButtonName] = useState('SIGNUP');
    const [isSignUp, setIsSignUp] = useState(true);
    const {burgerBuilding, authRedirectPath, onSetAuthRedirectPath} = props;
    useEffect(() => {
        if (!burgerBuilding && authRedirectPath !== '/') {
            onSetAuthRedirectPath();
        }
    }, [burgerBuilding, authRedirectPath, onSetAuthRedirectPath]);

    const inputChangehandler = (event, inputIdentifier) => {
        const updatedForm = updateObject(controls, {
            [inputIdentifier]: updateObject(controls[inputIdentifier], {
                value: event.target.value,
                valid: checkValidity(event.target.value, controls[inputIdentifier].validation),
                touched: true
            })
        });
        setControls(updatedForm);
    }

    const submitHandler = event => {
        event.preventDefault();
        props.onAuth(controls.email.value,
            controls.password.value, isSignUp);
    }

    const switchAuthModeHandler = (event) => {
        event.preventDefault();
        setButtonName(isSignUp ? 'LOGIN' : 'SIGNUP');
        setIsSignUp(!isSignUp);
    }


    let formArray = [];
    for (let key in controls) {
        formArray.push({
            id: key,
            config: controls[key]
        });
    }

    let form = formArray.map(e => {
        return <Input
            key={e.id}
            elementType={e.config.elementType}
            elementConfig={e.config.elementConfig}
            value={e.config.value}
            invalid={!e.config.valid}
            shouldValidate={e.config.validation}
            touched={e.config.touched}
            changed={(event) => inputChangehandler(event, e.id)} />
    });

    if (props.loading) {
        form = <Spinner />;
    }

    let errorMessage = null;
    if (props.error) {
        errorMessage = <p style={{ color: 'red' }}><strong>{props.error.message}</strong></p>
    }
    return <div className={classes.Auth}>
        {props.isAuthenticated ? <Redirect to={props.authRedirectPath} /> : null}
        {errorMessage}
        <form onSubmit={submitHandler}>
            {form}
            <Button btnType="Success" >{buttonName}</Button><br />
            <Button btnType="Danger" clicked={switchAuthModeHandler}>SWITCH TO {isSignUp ? 'LOGIN' : 'SIGNUP'}</Button>
        </form>
    </div>;

}

const mapStateToProps = state => {
    return {
        loading: state.auth.loading,
        error: state.auth.error,
        isAuthenticated: state.auth.token !== null,
        burgerBuilding: state.burgerBuilder.burgerBuilding,
        authRedirectPath: state.auth.authRedirectPath
    };
};

const mapDispatchToProps = dispatch => {
    return {
        onAuth: (email, password, isSignUp) => dispatch(actions.auth(email, password, isSignUp)),
        onSetAuthRedirectPath: () => dispatch(actions.setAuthRedirectPath('/'))
    }
}
export default connect(mapStateToProps, mapDispatchToProps)(auth);