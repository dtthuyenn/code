package com.cybersoft.uniclub.controller;

import com.cybersoft.uniclub.payload.response.BaseResponse;
import com.cybersoft.uniclub.repository.UserRepository;
import com.cybersoft.uniclub.services.AuthenticationServices;
import com.cybersoft.uniclub.services.imp.AuthenticationServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authen")

/*
    Viết xong câu truy vấn và trả ra đối tượng cho mình r
    Quay lại xử lý logic
    Khi người ta gọi controller authen/ sign-in của mình : họ sẽ  truyển vào email và password. Nhiệm vụ của mình là lấy email và password
    này thực hiện câu truy vấn. Thì câu truy vấn mình chuẩn bị trong repository nhưng
    Hiện tại controller không thể nào gọi trực tiếp repository đươc cả cho nên phải thông qua thằng services
    Cho nên đầu tiên mình phải tạo ra một thằng interface
    Hiện tại mình cần viết một hàm đẻ kiểm tra đăng nhập cho nên tạo ra interface là authenticationservices . Nó được dùng để xử lý logic code cho controller
    Vì kiểm tra đăng nhập đúng sai nên dùng keieerru dữ liệu boolean để kiểm  tra username và password
    Cần tạo ra một cái class

    Kieu optional dùng khi truy vấn  dữ liệu hoặc lấy dữ liệu ở bên thứ 3 mà mình kh bít được là nó có trả dữ liệu cho minh kh thi lúc đấy mình dùng kiểu
    Optional.
    Các trường hợp dùng Optional một là lấy dữ liệu ở nơi khác như truy vấn csdl hai là gọi bên third party ( thư viện bên ngoài ) thì mình đâu biết được nó
    có trả dữ liệu đượcc hay không thì mình dùng kiểu dữ liệu Optional bọc nó lại để kiêm tra tỉnh rỗng cho nó dễ


 */



public class AuthenticationController {

    @Autowired
    private AuthenticationServices authenticationServices ;




    @PostMapping("/sign-in")
    public ResponseEntity<?> signIn(@RequestParam String username, @RequestParam String password) {
      boolean isSuccess =  authenticationServices.authentication(username, password);
        BaseResponse response = new BaseResponse();
        response.setData(isSuccess);
        response.setMessage(isSuccess ? "Success" : "Failed");
        response.setCode(isSuccess ? 0 : 1);



        return  ResponseEntity.ok(response);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestParam String email, @RequestParam String password ) {
        boolean isSuccess =  authenticationServices.authenticate(email, password );

        BaseResponse response = new BaseResponse();
        response.setData(isSuccess);
        response.setMessage(isSuccess ? "Success" : "Failed");
        response.setCode(isSuccess ? 0 : 1);


        return  ResponseEntity.ok(response);
    }



}
