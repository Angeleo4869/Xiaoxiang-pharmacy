import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
//import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import TNavigation from './drawer.jsx';
import PropTypes from 'prop-types';

class CenterContainer extends React.Component{//类组件
   constructor(props){
      super(props);

   }
  render (){
   return(
   <React.Fragment>
      <CssBaseline />
      <Container maxWidth="lg">
          {/* <Typography component="div"  />  <div style={{textAlign:"right"}}>heloo</div>*/}
       
        <TNavigation />
    </Container>
    </React.Fragment>
   )};
}

CenterContainer.propTypes = {
  name: PropTypes.string
};

CenterContainer.defaultProps = {
  name: 'javaEE'
}
export default CenterContainer;