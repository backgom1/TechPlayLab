package com.mylab.techLab.old.common.exception;


import com.mylab.techLab.old.common.error.ErrorDetailResponse;
import com.mylab.techLab.old.common.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice(basePackages = "com.mylab.techLab.old")
public class GlobalExceptionHandler {


    /**
     * 애플리케이션에서 발생하는 모든 예외를 처리하는 전역 예외 처리기.
     * <p>
     * 이 메서드는 애플리케이션 실행 중 발생한 모든 예외를 포착하고,
     * 예외의 세부 정보를 로그로 기록한 후, 클라이언트에게 일반적인 오류 응답을 반환합니다.
     * 반환되는 응답은 HTTP 500 상태 코드를 포함하며, 알 수 없는 예외가 발생했음을 나타냅니다.
     * </p>
     *
     * @param e 발생한 예외 객체
     * @return "500" 오류 코드와 일반적인 오류 메시지를 포함한 ErrorResponse 객체
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exception(Exception e) {
        consoleErrorPrint("================== Exception 발생 ========================", e);
        return ErrorResponse.builder()
                .code("500")
                .message("알수없는 예외가 발생했습니다.").build();
    }


    /**
     * IllegalArgumentException 예외를 처리하는 메서드.
     * <p>
     * 이 메서드는 잘못된 인자 값이 전달되어 IllegalArgumentException이 발생한 경우 호출됩니다.
     * 예외 정보를 로그로 기록하고, 클라이언트에게 "Bad Request" 상태 코드와 함께 오류 응답을 반환합니다.
     * </p>
     *
     * @param e 발생한 IllegalArgumentException 예외 객체
     * @return "500" 오류 코드와 일반적인 오류 메시지를 포함한 ErrorResponse 객체
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse exception(IllegalArgumentException e) {
        consoleErrorPrint("================== IllegalArgumentException 발생 ========================", e);
        return ErrorResponse.builder()
                .code("500")
                .message("알수없는 예외가 발생했습니다.").build();
    }


    /**
     * MethodArgumentNotValidException 예외를 처리하는 메서드.
     * <p>
     * 이 메서드는 요청 파라미터가 유효성 검사를 통과하지 못한 경우 호출됩니다.
     * 유효성 검사를 통과하지 못한 필드와 해당 오류 메시지를 포함한 상세 오류 응답을 클라이언트에게 반환합니다.
     * </p>
     *
     * @param e 발생한 MethodArgumentNotValidException 예외 객체
     * @return "400" 오류 코드와 유효성 검사 오류 세부 정보를 포함한 ErrorDetailResponse 객체
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDetailResponse invalidRequestHandler(MethodArgumentNotValidException e) {

        ErrorDetailResponse response = ErrorDetailResponse.builder()
                .code("400")
                .message("잘못된 요청입니다.")
                .build();

        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }


    private void consoleErrorPrint(String s, Exception e) {
        log.error(s);
        log.error("원인 : {} ", e.getMessage());
        log.error("=========================================================");
    }

}
