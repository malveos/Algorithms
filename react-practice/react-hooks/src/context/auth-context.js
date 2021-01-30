import React, { useState } from 'react';

export const AuthContext = React.createContext({
    auth: false,
    login: () => {

    }
});

const AuthContextProvider = props => {
    const [isAuth, setAuth] = useState(false);

    const loginHandler = () => {
        setAuth(true);
    }

    return (
        <AuthContext.Provider value={{ login: loginHandler, auth: isAuth }} >
            {props.children}
        </AuthContext.Provider >
    );
}

export default AuthContextProvider;