import React, { useState } from 'react';
import { connect } from 'react-redux';

import Aux from '../AuxFile/Auxile';
import classes from './Layout.css';
import Toolbar from '../../components/Navigation/Toolbar/Toolbar';
import SideDrawer from '../../components/Navigation/SideDrawer/SideDrawer';

const Layout = props => {

    const [showSideDrawerVisible, setshowSideDrawerVisible] = useState(false);

    const sideDrawerCloseHandler = () => {
        setshowSideDrawerVisible(false)
    }

    const sideDrawerToggleHandler = () => {
        setshowSideDrawerVisible(!showSideDrawerVisible);
    }

    return <Aux>
        <Toolbar
            isAuth={props.isAuthenticated}
            drawerToggleClicked={sideDrawerToggleHandler} />
        <SideDrawer
            isAuth={props.isAuthenticated}
            open={showSideDrawerVisible}
            closed={sideDrawerCloseHandler} />
        <main className={classes.Content}>
            {props.children}
        </main>
    </Aux>;

};

const mapStateToProps = state => {
    return {
        isAuthenticated: state.auth.token !== null
    }
};

export default connect(mapStateToProps)(Layout);