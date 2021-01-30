import { useState, useEffect } from "react";

let globalState = {};
let listeners = [];
let actions = {};

export const useStore = (shouldListen= true) => {
    const setState = useState(globalState)[1];
    const dispatch = (action, payload) => {
        const newState = actions[action](globalState, payload);
        globalState = { ...globalState, ...newState };

        for (const list of listeners) {
            list(globalState);
        }
    };
    useEffect(() => {
        if(shouldListen) {
            listeners.push(setState);
        }        
        return () => {
            if(shouldListen) {
                listeners = listeners.filter(l => l !== setState);
            }            
        }
    }, [setState, shouldListen])

    return [globalState, dispatch];
}

export const initStore = (userAction, initialState) => {
    if (initialState) {
        globalState = { ...globalState, ...initialState };
    }
    actions = { ...actions, ...userAction };
}