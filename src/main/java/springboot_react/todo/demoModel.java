package springboot_react.todo;


import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class demoModel {

    @NonNull
    private String id;
    
}
