import React,{ Component, useState } from "react";




class Data extends Component{

    //state = this.props;
    state = {
        data : []
      }
      temp = [];
      componentDidMount() {
        const apiUrl = "https://api.github.com/users/hadley/orgs";
        fetch(apiUrl)
          .then((response) => response.json())
          .then((res) => {
            this.temp = [];
            console.log('This is your data1', res)
            this.temp.push(res);
            console.log('This is your temp', this.temp)
            this.setState({ data: res})
        });
      }
    render(){
         const remove = (rowId) => {
            // Array.prototype.filter returns new array
            // so we aren't mutating state here
            
            const arrayCopy = this.state.data.filter((row) => row.id !== rowId);
            this.setState({data: arrayCopy});
          };
        return(
        <table className = "table" style = {{border: "5px solid black"}}>
            <thead>
            <tr>
                <th scope = "col">ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
                {this.state.data.map(row => (
                    <tr>
                        <th scope = "col">{row.id}</th>
                        <td>{row.login}</td>
                        <td>{row.url}</td>
                        <td><input type="button" value="Delete" onClick={() => remove(row.id)} /> </td>
                    </tr>
                ))}
                </tbody>
        </table>
        );}

}

export default Data;