import React from 'react';
import axios from 'axios';

class App extends React.Component {
  constructor(props){
    super(props);
    this.state={
      users:[],
      id:0,
      Name:'',
      Email:'',
      Password:''
    }
  }

  componentDidMount()
  {
    axios.get("http://localhost:8080/api/v1/movies")
    .then((res)=>{
      this.setState({
        //state: any, callback? () => void): void
        users:res.data,
        id:0,
        name:'',
        email:'',
        password:''
      })
    })
  }
  Submit(event,id){
    event.preventDefault();
    if(id===0){
      axios.post("http://localhost:8080/api/v1/movies/",{
        name:this.state.name,
        email:this.state.email,
        password:this.state.password
      }).then(()=>{
        this.componentDidMount();
      })
    }
    else{
      axios.post("http://localhost:8080/api/v1/movies/",{
        id:id,
        name:this.state.name,
        email:this.state.email,
        password:this.state.password
      }).then(()=>{
        this.componentDidMount();
      })
    }
  }

  delete(id)
  {
    axios.delete("http://localhost:8080/api/v1/movies/"+id)
    .then(()=>{
      this.componentDidMount();

    })
  }

  edit(id)
  {
    axios.get("http://localhost:8080/api/v1/movies/"+id)
    .then((res)=>{
      this.setState({
        id:id,
        name:res.data.name,
        email:res.data.email,
        password:res.data.password
      
      });
    });

  }

  render() 
  {

      return (
        <div classNameName="container">
          <div classNameName="row">
            <div classNameName="col s6">
              <form onSubmit={(e)=>this.Submit(e, this.state.id)}>
                <div className="input-field col s12">
                  <i className="material-icons prefix">person</i>
                  <input value={this.state.name} onChange={(e)=> this.setState({name:e.target.value})} type="text" id="autocomplete-input" className="autocomplete"/>
                  <label htmlFor="autocomplete-input">Enter Your Name</label>
                </div>
                <div className="input-field col s12">
                  <i className="material-icons prefix">mail</i>
                  <input value={this.state.email} onChange={(e)=> this.setState({email:e.target.value})} type="email" id="autocomplete-input" className="autocomplete"/>
                  <label htmlFor="autocomplete-input">Enter Email</label>
                </div>
                <div className="input-field col s12">
                  <i className="material-icons prefix">vpn_key</i>
                  <input value={this.state.password} onChange={(e)=> this.setState({password:e.target.value})} type="password" id="autocomplete-input" className="autocomplete"/>
                  <label htmlFor="autocomplete-input">Enter Password</label>
                </div>

                <button className="btn waves-effect waves-light right" type="submit" name="action">Submit
                    <i className="material-icons right">send</i>
                </button>




              </form>          
            </div>
            <div classNameName='col s6'>

            <table>
        <thead>
          <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Password</th>
              <th>Edit</th>
              <th>Delete</th>
          </tr>
        </thead>

        <tbody>
          {
            this.state.users.map(user =>
              <tr key={user.id}>
                  <td>{user.name}</td>
                  <td>{user.email}</td>
                  <td>{user.password}</td>
                  <td>
                    <button onClick={(e)=> this.edit(user.id)} className="btn waves-effect waves-light" type="submit" name="action">Submit
                      <i className="material-icons">edit</i>
                    </button>
                  </td>

                  <td>
                    <button onClick={(e)=> this.delete(user.id)} className="btn waves-effect waves-light" type="submit" name="action">Submit
                      <i className="material-icons">delet</i>
                    </button>
                  </td>

              </tr>

            )
          }

          
          
        </tbody>
      </table>



            </div>
          </div>
        </div>
      );
  }
}

export default App;
